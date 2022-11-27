import telegram


def send_bot(my_caption, photo_path='./alert.jpg'):
  try:
    my_token = '5695105590:AAFu3zUFROH5vfBJCrS2Tcz7C5pcgox8Kpc'
    manager_bot = telegram.Bot(token=my_token)
    manager_bot.send_photo(chat_id='5654518015', photo=open(photo_path,'rb'),caption=my_caption)
  except:
    pass
