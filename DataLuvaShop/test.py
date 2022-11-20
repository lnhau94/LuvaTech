import numpy as np
import pandas as pd
import psycopg2
from psycopg2.extensions import register_adapter, AsIs
psycopg2.extensions.register_adapter(np.int64, psycopg2._psycopg.AsIs)
df_brand = pd.read_excel('./phone_laptop_watch_data_tth.xlsx',engine='openpyxl',sheet_name='Brand')
df_product = pd.read_excel('./phone_laptop_watch_data_tth.xlsx', engine='openpyxl',sheet_name='Product')
df_phone = pd.read_excel('./phone_laptop_watch_data_tth.xlsx',engine='openpyxl',sheet_name='Phone',dtype={'SKU': object,'ProductID': object})
df_phoneinfo = pd.read_excel('./phone_laptop_watch_data_tth.xlsx',engine='openpyxl',sheet_name='PhoneInfo',dtype={'ProductID': object})
df_laptop = pd.read_excel('./phone_laptop_watch_data_tth.xlsx',engine='openpyxl',sheet_name='Laptop',dtype={'SKU': object,'ProductID': object})
df_laptopinfo = pd.read_excel('./phone_laptop_watch_data_tth.xlsx',engine='openpyxl',sheet_name='LaptopInfo',dtype={'ProductID': object})
df_watch = pd.read_excel('./phone_laptop_watch_data_tth.xlsx',engine='openpyxl',sheet_name='Watch',dtype={'SKU': object,'ProductID': object})
df_watchinfo = pd.read_excel('./phone_laptop_watch_data_tth.xlsx',engine='openpyxl',sheet_name='WatchInfo',dtype={'ProductID': object})
conn = psycopg2.connect(
    host='localhost',
    database='postgres',
    user='postgres',
    password='',
    port='5432',
    options='-c search_path=luvashop'
)
cur=conn.cursor()
for i in range(df_brand.shape[0]):
    cur.execute("Insert into Brand(BrandName, BrandCountry) values (%s, %s);", (df_brand['BrandName'][i],df_brand['BrandCountry'][i]))
for i in range(df_product.shape[0]):
    cur.execute("Insert into Product(ProductName, BrandID) values (%s, %s);", (df_product['ProductName'][i],df_product['BrandID'][i]))
for i in range(df_phone.shape[0]):
    cur.execute("Insert into Specification(SKU,ProductID,Price,Instock) values (%s, %s, %s, %s);", (df_phone['SKU'][i],df_phone['ProductID'][i], df_phone['Price'][i], df_phone['Instock'][i]))
    cur.execute("Insert into PhoneVariation(SKU,phoneram,phonecolor,phonestorage) values (%s, %s, %s, %s);", (df_phone['SKU'][i],df_phone['Ram'][i], df_phone['Color'][i], df_phone['Storage'][i]))
for i in range(df_phoneinfo.shape[0]):
    cur.execute("Insert into PhoneInfo(productid,chip,screen,connected,os,material,battery,sim,camera) values (%s, %s, %s, %s, %s, %s, %s, %s, %s);", (df_phoneinfo['ProductID'][i],df_phoneinfo['CPU'][i], df_phoneinfo['Screen'][i], df_phoneinfo['Connect'][i], df_phoneinfo['OS'][i], df_phoneinfo['Material'][i],df_phoneinfo['Pin'][i],df_phoneinfo['SIM'][i],df_phoneinfo['Camera'][i]))
for i in range(df_laptop.shape[0]):
    cur.execute("Insert into Specification(SKU,ProductID,Price,Instock) values (%s, %s, %s, %s);", (df_laptop['SKU'][i],df_laptop['ProductID'][i], df_laptop['Price'][i], df_laptop['Instock'][i]))
    cur.execute("Insert into LaptopVariation(SKU,laptopram,laptopcolor,laptopcpu) values (%s, %s, %s, %s);", (df_laptop['SKU'][i],df_laptop['RAM'][i], df_laptop['Color'][i], df_laptop['CPU'][i]))
for i in range(df_laptopinfo.shape[0]):
    cur.execute("Insert into LaptopInfo(productid,screen,connected,os,material,laptopsize,weight,camera) values (%s, %s, %s, %s, %s, %s, %s, %s);", (df_laptopinfo['ProductID'][i], df_laptopinfo['Screen'][i], df_laptopinfo['Connect'][i], df_laptopinfo['OS'][i], df_laptopinfo['Material'][i],df_laptopinfo['Size'][i],df_laptopinfo['Weight'][i],df_laptopinfo['Camera'][i]))
for i in range(df_watch.shape[0]):
    cur.execute("Insert into Specification(SKU,ProductID,Price,Instock) values (%s, %s, %s, %s);", (df_watch['SKU'][i],df_watch['ProductID'][i], df_watch['Price'][i], df_watch['Instock'][i]))
    cur.execute("Insert into SmartWatchVariation(SKU,smartwatchedition,smartwatchcolor) values (%s, %s, %s);", (df_watch['SKU'][i],df_watch['Edition'][i], df_watch['Color'][i]))
for i in range(df_watchinfo.shape[0]):
    cur.execute("Insert into SmartWatchInfo(productid,screen,frontglass,os,battery) values (%s, %s, %s, %s, %s);",(df_watchinfo['ProductID'][i], df_watchinfo['Screen'][i],df_watchinfo['Glass'][i],df_watchinfo['OS'][i],df_watchinfo['Pin'][i]))
conn.commit()
cur.close()
conn.close()