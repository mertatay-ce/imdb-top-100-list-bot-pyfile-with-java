import requests
from bs4 import BeautifulSoup

r= requests.get('https://www.imdb.com/search/title/?groups=top_100&sort=user_rating,desc')
kaynak = BeautifulSoup(r.content,"lxml")
filmler = kaynak.find_all("div",attrs={'class':'lister-item-content'})

r2 = requests.get('https://www.imdb.com/search/title/?groups=top_100&sort=user_rating,desc&start=51&ref_=adv_nxt')
kaynak2 = BeautifulSoup(r2.content,'lxml')
filmler2 = kaynak2.find_all("div",attrs={'class':'lister-item-content'})
 
filmler.extend(filmler2)

for film in filmler:
    print(film.h3.a.text)
