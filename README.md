POST : http://localhost:1940/api/v0/ethiopian/save/customer

RequestBody:
{
"firstName":   "Beakal",
"lastName":    "Messele",
"email":       "beakal@beakal.com",
"phoneNumber": "101-456-7890",
"source":      "ADD",
"destination": "DFW"

}

Response:
{
"custId": 1,
"firstName": "Beakal",
"lastName": "Messele",
"email": "beakal@beakal.com",
"phoneNumber": "101-456-7890",
"destination": "DFW",
"source": "ADD",
"status": "ECONOMY",
"registeredDate": "2026-07-20T22:56:56.343+00:00",
"pin": 6343
}

#############----confirmation path -----------------

POST http://localhost:1941/api/v0/flight/booking/confirm/

RequestBody

{
"email":       "beakal@beakal.com",
"phoneNumber": "101-456-7890",
"source":      "ADD",
"destination": "DFW"
}

Response:
{
"bookingId": "769D5E54",
"firstName": "Beakal",
"lastName": "Messele",
"createdAt": "2026-07-20T17:57:20.8699296",
"status": "CONFIRMED",
"source": "ADD",
"destination": "DFW"
}

GET : http://localhost:1940/api/v0/ethiopian/get/customer/destination?location=DFW

[
{
"custId": 1,
"firstName": "Beakal",
"lastName": "Messele",
"email": "beakal@beakal.com",
"phoneNumber": "101-456-7890",
"destination": "DFW",
"source": "ADD",
"status": "ECONOMY",
"registeredDate": "2026-07-20T22:56:56.343+00:00",
"pin": 6343
},
{
"custId": 2,
"firstName": "Beakal",
"lastName": "Messele",
"email": "beakal@beakal.com",
"phoneNumber": "101-456-7890",
"destination": "DFW",
"source": "ADD",
"status": "ECONOMY",
"registeredDate": "2026-07-20T23:03:31.040+00:00",
"pin": 1040
},
{
"custId": 4,
"firstName": "Williy",
"lastName": "Milli",
"email": "williy@willy.com",
"phoneNumber": "702-456-7890",
"destination": "DFW",
"source": "ADD",
"status": "ECONOMY",
"registeredDate": "2026-07-20T23:09:23.115+00:00",
"pin": 3115
}
]