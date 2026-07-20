postman request POST 'http://localhost:1940/api/v0/ethiopian/save/customer' \
--header 'Content-Type: application/json' \
--body '{
"firstName":   "Beakal",
"lastName":    "Messele",
"email":       "beakal@beakal.com",
"phoneNumber": "702-456-7890",
"source":      "ADD",
"destination": "DFW"

}'

############# response ##############
{
"custId": 4,
"firstName": "Beakal",
"lastName": "Messele",
"email": "beakal@beakal.com",
"phoneNumber": "702-456-7890",
"destination": "DFW",
"source": "ADD",
"status": "ECONOMY",
"registeredDate": "2026-07-20T23:09:23.115+00:00",
"pin": 3115
}

################---------------------

postman request POST 'http://localhost:1941/api/v0/flight/booking/confirm/' \
--header 'Content-Type: application/json' \
--body '{
"email":       "beakal@beakal.com",
"phoneNumber": "101-456-7890",
"source":      "ADD",
"destination": "DFW"
}'

############-----------response-----------
{
"bookingId": "769D5E54",
"firstName": "Beakal",
"lastName": "Messele",
"createdAt": "2026-07-20T17:57:20.8699296",
"status": "CONFIRMED",
"source": "ADD",
"destination": "DFW"
}