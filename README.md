# Instant Username Search Rest Api

Rest Api of the instant-username-search project.

## Client Repository
The client repo will be here.

## Installation

You need maven installed on your system to run the project. Cd into the project directory and run the following command to start the application. Rest API will accept requests at port 8080.

```sh
mvn spring-boot:run
```

## Endpoints

- Request to `/github/username` will check the availability of username on GitHub.
```json
{
  "url": "https://www.github.com/username",
  "available": true,
  "message": null
}
```

- Request to `/services/getAll` will list the available websites to check.

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
    "service": "Google Plus",
    "endpoint": "/google plus/{username}"
  },

  .
  .
  .

  {
    "service": "Reddit",
    "endpoint": "/reddit/{username}"
  },
  {
    "service": "Pinterest",
    "endpoint": "/pinterest/{username}"
  },
  {
    "service": "GitHub",
    "endpoint": "/github/{username}"
  }
]
```



## Credits
Developed by [Umut Canbolat](https://github.com/umutcanbolat).

## License
This project is licensed under the GNU General Public License v3.0 (GPL 3.0) - see the [LICENSE](LICENSE) file for details
