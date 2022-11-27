import sys
import os
import cv2
import pandas as pd
import numpy as np
import openpyxl
import datetime
from PIL import Image
import pickle
import time
from gtts import gTTS
import playsound
from googletrans import Translator
from telegram_bot import send_bot 
import threading
from threading import Thread
# cv2.cuda.setDevice(0)

class ThreadWithReturnValue(Thread):
    
  def __init__(self, group=None, target=None, name=None,
              args=(), kwargs={}, Verbose=None):
    Thread.__init__(self, group, target, name, args, kwargs)
    self._return = None
  def run(self):
    if self._target is not None:
        self._return = self._target(*self._args,
                                            **self._kwargs)
  def join(self, *args):
    Thread.join(self, *args)
    return self._return

def myInit(): 
  # Khởi tạo bộ phát hiện khuôn mặt
  faceDetect=cv2.CascadeClassifier('./haarcascade_frontalface_alt2.xml')
  # Khởi tạo bộ nhận diện khuôn mặt
  recognizer = cv2.face.LBPHFaceRecognizer_create()
  recognizer.read('./recognize/trainner.yml') 
  return faceDetect, recognizer
t0 = ThreadWithReturnValue(target=myInit)
t0.start()
faceDetect, recognizer = t0.join()  
id=0
#Set kiểu chữ
fontface = cv2.FONT_HERSHEY_SIMPLEX
fontscale = 0.7
fontcolor = (0,255,0)
fontcolor1 = (0,0,255)
header = ['ID', 'Name', 'TimeCheckIn']
# Khởi tạo camera
cam=cv2.VideoCapture(0)
cam.set(3, 640)
cam.set(4, 480)
df = pd.read_excel('./emp.xlsx',engine='openpyxl',dtype='str')

def speak(audio):
  text_to_speech = gTTS(text=audio, lang='vi')
  os.remove('audio.mp3')
  text_to_speech.save('audio.mp3')
  playsound.playsound('audio.mp3')


def faceReg(img,gray,faces,recognizer,checkFace,df,fontface,fontscale,fontcolor,fontcolor1):
  profile=pd.DataFrame()
  # if cv2.waitKey(1) & 0xFF==ord('r'):
  # Lặp qua các khuôn mặt nhận được để hiện thông tin
  for(x,y,w,h) in faces:
    # Vẽ hình chữ nhật quanh mặt
    cv2.rectangle(img,(x,y),(x+w,y+h),(255,0,0),2)

    # Nhận diện khuôn mặt, trả ra 2 tham số id: mã nhân viên và dist (dộ sai khác)
    id,dist=recognizer.predict(gray[y:y+h,x:x+w])
    print(id)
    print(dist)
    # Nếu độ sai <= 37% thì lấy profile
    if (dist<=37):
      profile = df[df['ID'].astype(int)==int(id)]['Name']
      profile_id = df[df['ID'].astype(int)==int(id)]['ID']
  
    # Hiển thị thông tin tên người hoặc Unknown nếu không tìm thấy
    if(profile.size!=0):
      #Chuyển đổi tiếng việt sang tiếng anh để hiển thị lên camera
      translator = Translator()
      name_rv = translator.translate(profile.iloc[0], src="vi", dest="en")
      result_name = name_rv.text.replace(' ','')
      cv2.putText(img, f"{result_name}-ID:{profile_id.iloc[0]}", (x,y+h+30), fontface, fontscale, fontcolor ,2)
      checkFace=True
      cv2.imwrite('alert.jpg',cv2.resize(img,dsize=None,fx=0.5,fy=0.5))
      thread = threading.Thread(target=send_bot, args=(f'{result_name}-ID:{profile_id.iloc[0]}  ###  {datetime.datetime.now().strftime("%d-%m-%Y %H:%M:%S")}',))
      thread.start()
      break
    else:
      cv2.putText(img, f"Unknown", (x, y + h + 30), fontface, fontscale, fontcolor1, 2)
  return profile, checkFace

def readFace(cam):
  # Đọc ảnh từ camera
  ret,img=cam.read()

  # Lật ảnh cho đỡ bị ngược
  img = cv2.flip(img, 1)

  # Chuyển ảnh về xám
  gray=cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)

  # Phát hiện các khuôn mặt trong ảnh camera
  faces=faceDetect.detectMultiScale(gray,1.3,5)
  return img, gray, faces
while(True):
  checkFace = False
  if cv2.waitKey(1) & 0xFF==ord('q'):
    break
  t1 = ThreadWithReturnValue(target=readFace, args=(cam,))
  t1.start()
  img, gray, faces = t1.join()
  t2 = ThreadWithReturnValue(target=faceReg, args=(img,gray,faces,recognizer,checkFace,df,fontface,fontscale,fontcolor,fontcolor1,))
  t2.start()
  profile, checkFace = t2.join()

  cv2.imshow('Face Recognition',img)
  # Nếu nhấn q thì thoát
  if cv2.waitKey(1) & 0xFF==ord('q'):
    break
  if checkFace:
    t3 = threading.Thread(target=speak, args=(f"Xin chào {profile.iloc[0]}",))  
    t3.start()   
    break
cam.release()
cv2.destroyAllWindows()