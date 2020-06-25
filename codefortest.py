import requests

url = "https://projetocentraldeerros.herokuapp.com/oauth/token"

payload = "------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"grant_type\"\r\n\r\npassword\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"username\"\r\n\r\nmarco\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"password\"\r\n\r\n123\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--"
headers = {
   'content-type': "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW",
   'authorization': "Basic Y29kZW5hdGlvbjpjb2RlbmF0aW9uMTIz",
   'cache-control': "no-cache",
   'postman-token': "a0f5ab40-77d2-6a41-64d2-9847ed2b3cc0"
   }

response = requests.request("POST", url, data=payload, headers=headers)

data = response.json();

print(data["access_token"])

url2 = "https://projetocentraldeerros.herokuapp.com/errorlog"
token = str(data["access_token"])

headers = {
   'authorization': "Bearer " + token,
   'cache-control': "no-cache",
   'postman-token': "e0432565-0e65-503b-42c1-1d7520154f9c"
   }

response2 = requests.request("GET", url2, headers=headers)

data2 = response2.json();

print(data2[2])

url3 = "https://projetocentraldeerros.herokuapp.com/errorlog/ByQuantity/2"

response3 = requests.request("GET", url3, headers=headers, data = payload)

data3 = response3.json();

print(data3)

url4 = "https://projetocentraldeerros.herokuapp.com/errorlog/5"

response4 = requests.request("GET", url4, headers=headers, data = payload)

data4 = response4.json();

print(data4)
