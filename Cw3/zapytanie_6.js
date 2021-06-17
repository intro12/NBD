printjson(db.people.insert({
        "sex" : "Male",
        "first_name" : "Aleksander",
        "last_name" : "Kowalski",
        "job" : "Developer",
        "email" : "akowalski@gmail.com",
        "location" : {
                "city" : "Warsaw",
                "address" : {
                        "streetname" : "Chmielna",
                        "streetnumber" : "100"
                }
        },
        "description" : "jam fajny czlek",
        "height" : "183",
        "weight" : "90",
        "birth_date" : "1992-04-27T05:05:03Z",
        "nationality" : "Poland",
        "credit" : [
                {
                        "type" : "switch",
                        "number" : "172389127937128978",
                        "currency" : "PLN",
                        "balance" : "2000.06"
                }
        ]
}))
