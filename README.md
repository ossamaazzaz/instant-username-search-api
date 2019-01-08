# Instant Username Search Rest Api

Rest Api of the instan-username-search project.

## Client Repository
The client repo will be here.

## Installation

You need maven installed on your system to run the project. Cd into the project directory and run the following command to start the application. Rest API will accept requests at port 8080.

```sh
mvn spring-boot:run
```

## Endpoints

- Request to `/github/username` will check the availability of username on GitHub.
- Request to `/services/getAll` will list the available websites to check.

```json
{
  "url": "https://www.github.com/username",
  "available": true,
  "message": null
}
```

## Credits
Developed by [Umut Canbolat](https://github.com/umutcanbolat).

## License
This project is licensed under the GNU General Public License v3.0 (GPL 3.0) - see the [LICENSE](LICENSE) file for details
