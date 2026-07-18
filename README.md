##  http://localhost:1940/api/v0/ethiopian/get/customer/status?status=ECONOMY
[
    {
        "custId": 1,
        "custName": "Beakal",
        "custEmail": "beakal@beakal.com",
        "custPhone": "123-456-7890",
        "destination": "ADD",
        "status": "ECONOMY",
        "registeredDate": "2026-07-18T21:53:20.288+00:00",
        "pin": 288
    },
    {
        "custId": 2,
        "custName": "Mulugeta",
        "custEmail": "mulugeta@mulugeta.com",
        "custPhone": "202-456-7890",
        "destination": "DCA",
        "status": "ECONOMY",
        "registeredDate": "2026-07-18T21:55:51.153+00:00",
        "pin": 1153
    },
    {
        "custId": 3,
        "custName": "testfa",
        "custEmail": "tesfa@tesfa.com",
        "custPhone": "404-456-7890",
        "destination": "LHR",
        "status": "ECONOMY",
        "registeredDate": "2026-07-18T21:57:31.555+00:00",
        "pin": 1555
    },
    {
        "custId": 4,
        "custName": "getu",
        "custEmail": "getu@getu.com",
        "custPhone": "909-456-7890",
        "destination": "LAS",
        "status": "ECONOMY",
        "registeredDate": "2026-07-18T21:58:58.253+00:00",
        "pin": 8253
    },
    {
        "custId": 5,
        "custName": "getu",
        "custEmail": "getu@getu.com",
        "custPhone": "909-456-7890",
        "destination": "ADD",
        "status": "ECONOMY",
        "registeredDate": "2026-07-18T22:53:20.676+00:00",
        "pin": 676
    },
    {
        "custId": 6,
        "custName": "toki",
        "custEmail": "toki@toki.com",
        "custPhone": "981-456-7890",
        "destination": "ADD",
        "status": "ECONOMY",
        "registeredDate": "2026-07-18T22:54:11.434+00:00",
        "pin": 1434
    },
    {
        "custId": 7,
        "custName": "Jimmy",
        "custEmail": "Jimmy@Jimmy.com",
        "custPhone": "981-456-7890",
        "destination": "DCA",
        "status": "ECONOMY",
        "registeredDate": "2026-07-18T22:54:35.153+00:00",
        "pin": 5153
    },
    {
        "custId": 8,
        "custName": "Willy",
        "custEmail": "Willy@Willy.com",
        "custPhone": "101-456-7890",
        "destination": "DCA",
        "status": "ECONOMY",
        "registeredDate": "2026-07-18T22:55:24.396+00:00",
        "pin": 4396
    },
    {
        "custId": 9,
        "custName": "Willy",
        "custEmail": "Willy@Willy.com",
        "custPhone": "101-456-7890",
        "destination": "ADD",
        "status": "ECONOMY",
        "registeredDate": "2026-07-18T22:55:38.682+00:00",
        "pin": 8682
    }
]
##  http://localhost:1940/api/v0/ethiopian/get/customer/destination?location=DCA
[
    {
        "custId": 2,
        "custName": "Mulugeta",
        "custEmail": "mulugeta@mulugeta.com",
        "custPhone": "202-456-7890",
        "destination": "DCA",
        "status": "ECONOMY",
        "registeredDate": "2026-07-18T21:55:51.153+00:00",
        "pin": 1153
    },
    {
        "custId": 7,
        "custName": "Jimmy",
        "custEmail": "Jimmy@Jimmy.com",
        "custPhone": "981-456-7890",
        "destination": "DCA",
        "status": "ECONOMY",
        "registeredDate": "2026-07-18T22:54:35.153+00:00",
        "pin": 5153
    },
    {
        "custId": 8,
        "custName": "Willy",
        "custEmail": "Willy@Willy.com",
        "custPhone": "101-456-7890",
        "destination": "DCA",
        "status": "ECONOMY",
        "registeredDate": "2026-07-18T22:55:24.396+00:00",
        "pin": 4396
    }
]

## request body
{
    "custName":"Willy",
    "custEmail":"Willy@Willy.com",
    "custPhone":"101-456-7890",
    "destination":"ADD"

}
##  http://localhost:1940/api/v0/ethiopian/save/customer{
    "custId": 9,
    "custName": "Willy",
    "custEmail": "Willy@Willy.com",
    "custPhone": "101-456-7890",
    "destination": "ADD",
    "status": "ECONOMY",
    "registeredDate": "2026-07-18T22:55:38.682+00:00",
    "pin": 8682
}
