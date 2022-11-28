import os
import cv2
import sys
import numpy as np
import pandas as pd
import openpyxl
import xlsxwriter
from gtts import gTTS
import playsound
from googletrans import Translator
from sqlalchemy.engine import URL
from sqlalchemy import create_engine
from googletrans import Translator
import platform

cam = cv2.VideoCapture(0)
detector=cv2.CascadeClassifier('./haarcascade_frontalface_alt2.xml')

# Hàm cập nhật tên và ID vào file Excel
def insertOrUpdate(id, name):
    # drivers = [item for item in pyodbc.drivers()]
    # driver = drivers[-1]
    # conn_str = f'Driver={driver};Server=localhost;Database=CORNSHOP;UID=sa;PWD=Huy0908617538huy;Trusted_Connection=no;Encrypt=no;'
    # connection_url = URL.create("mssql+pyodbc", query={"odbc_connect": conn_str})
    # engine = create_engine(connection_url)
    # df = pd.read_sql_query('select * from ACCOUNT', engine)
    # print(df)
    df = pd.read_excel('./emp.xlsx',engine='openpyxl',dtype='str')
    if len(np.where(df['ID']==id)[0]) == 0:
        df.loc[len(df.index)] = [id, name]
        employee_workbook = xlsxwriter.Workbook('emp.xlsx')
        employee_worksheet = employee_workbook.add_worksheet('Emp')
        for i in range(df.shape[0]+1):
            if i == 0:
                employee_worksheet.write(i, 0, 'ID')
                employee_worksheet.write(i, 1, 'Name')
            else: 
                employee_worksheet.write(i, 0, df['ID'][i-1])
                employee_worksheet.write(i, 1, df['Name'][i-1])
        employee_workbook.close()

def getEndValue(path, id):
    count=0
    imagePaths=[os.path.join(path,f) for f in os.listdir(path)]     
    for imagePath in imagePaths:
        if (imagePath[-3:]=="jpg"):
            Id=int(os.path.split(imagePath)[-1].split(".")[1])
            if Id == int(id):
                count+=1
    return count

def speak(audio):
    text_to_speech = gTTS(text=audio, lang='vi')
    os.remove("audio1.mp3")
    text_to_speech.save("audio1.mp3")
    playsound.playsound("audio1.mp3")

    
id=input('Nhập mã nhân viên:')
name=input('Nhập tên nhân viên:')
translator = Translator()
name_rv = translator.translate(name, src="vi", dest="en")
name = name_rv.text.replace(' ','')
print("Bắt đầu chụp ảnh nhân viên, nhấn q để thoát!")

insertOrUpdate(id,name)
sampleNum=getEndValue('./datasetFace', id)
tmpCount=0

while(True):
    ret, img = cam.read()

    # Lật ảnh cho đỡ bị ngược
    img = cv2.flip(img,1)

    # Đưa ảnh về ảnh xám
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

    # Nhận diện khuôn mặt
    faces = detector.detectMultiScale(gray, 1.3, 5)
    for (x, y, w, h) in faces:
        # Vẽ hình chữ nhật quanh mặt nhận được
        cv2.rectangle(img, (x, y), (x + w, y + h), (255, 0, 0), 2)
        sampleNum = sampleNum + 1
        tmpCount = tmpCount + 1
        # Ghi dữ liệu khuôn mặt vào thư mục dataSet
        cv2.imwrite(f"./datasetFace/{name}." + id + '.' + str(sampleNum) + ".jpg", gray[y:y + h, x:x + w])

    cv2.imshow('frame', img)
    # Check xem có bấm q hoặc trên 100 ảnh thì thoát
    if cv2.waitKey(100) & 0xFF == ord('q'):
        if platform.system() == "Windows":
          speak("Xin vui lòng đợi trong giây lát")
          os.system('python TrainModel.py')
          speak("Đã ghi nhận khuôn mặt của bạn")
        else:
          speak("Xin vui lòng đợi trong giây lát")
          os.system('python3.9 TrainModel.py')
          speak("Đã ghi nhận khuôn mặt của bạn")
        break
    elif tmpCount>100:
        if platform.system() == "Windows":
          speak("Xin vui lòng đợi trong giây lát")
          os.system('python TrainModel.py')
          speak("Đã ghi nhận khuôn mặt của bạn")
        else:
          speak("Xin vui lòng đợi trong giây lát")
          os.system('python3.9 TrainModel.py')
          speak("Đã ghi nhận khuôn mặt của bạn")
        break

cam.release()
cv2.destroyAllWindows()