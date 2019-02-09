# Instant Username Search Rest Api
[![Build Status](https://travis-ci.org/umutcanbolat/instant-username-search-api.svg?branch=master)](https://travis-ci.org/umutcanbolat/instant-username-search-api)

Rest Api of the instant-username-search project.

## Client Repository
Check the client repo here: 
[instant-username-search](https://github.com/umutcanbolat/instant-username-search)


## Installation

You need maven installed on your system to run the project. Cd into the project directory and run the following command to start the application. Rest API will accept requests at port 8080.

```sh
mvn spring-boot:run
```

## Endpoints

- Request to `/check/github/torvalds` will check the availability of the username `torvalds` on GitHub.
```json
{
  "service": "GitHub",
  "url": "https://www.github.com/torvalds",
  "available": false,
  "message": null
}
```

- Request to `/services/getAll` will list the all available websites to check for username.

```json
[
  {
    "service": "Instagram",
    "endpoint": "/instagram/{username}"
  },
  {
    "service": "Twitter",
    "endpoint": "/twitter/{username}"
  },
  {
    "service": "Facebook",
    "endpoint": "/facebook/{username}"
  },
  {
    "service": "YouTube",
    "endpoint": "/youtube/{username}"
  },
  {
    "service": "Blogger",
    "endpoint": "/blogger/{username}"
  },
  {
    "service": "Reddit",
    "endpoint": "/reddit/{username}"
  }
]
```



## Credits
Developed by [Umut Canbolat](https://github.com/umutcanbolat).

## License
This project is licensed under the GNU General Public License v3.0 (GPL 3.0) - see the [LICENSE](LICENSE) file for details
