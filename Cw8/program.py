import riak

myClient = riak.RiakClient(pb_port=8087)
myBucket = myClient.bucket('s23679')

game = {"name": "Cyberpunk 2077", "genre": "RPG", "price": 150.00, "studioName": "CD Project RED"}
print("Dodawana gra: ",game)
newGame = myBucket.new('cyberpunk',data=game)
newGame.store()

cyberpunk = myBucket.get('cyberpunk')

print("Wynik po dodaniu gry: ", cyberpunk.encoded_data)

cyberpunk.data["price"] = 200.00
print("Modyfikacja pola price z 150.00 na 200.00")
cyberpunk.store()

cyberpunk = myBucket.get('cyberpunk')

print("Wynik po modfyfikacji gry: ", cyberpunk.encoded_data)

print("Usuwam gre")
cyberpunk.delete()

cyberpunk = myBucket.get('cyberpunk')

print("Wynik po modfyfikacji gry: ", cyberpunk.encoded_data)

