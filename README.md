Basic Web Service
=================

## Developing in docker

### Install container and run app

```
$ docker pull postgres
$ docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres
```

### Connect to postgres container

```
$ docker run -it --rm --link postgres:postgres postgres psql -h postgres -U postgres
```

### Build basic service image

```
$ ./build.sh
```

### Run basic service container

```
$ docker run --name basic-service --link postgres:postgres -d basic-service
```