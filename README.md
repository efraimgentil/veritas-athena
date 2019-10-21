# Athena


### RabbitMQ

Local address: http://127.0.0.1:15672/#/

### TODO

Create keyspace used by the application locally 
    (should setup something to create when missing? for new environments only...)
```$xslt
CREATE KEYSPACE IF NOT EXISTS athena 
    WITH REPLICATION = { 
        'class' : 'SimpleStrategy'
        , 'replication_factor' : 1 
    };
```

### CASSANDRA DOCKER

Connect to cassandra CQLSh locally
```
$ docker-compose exec cassandra cqlsh
```
Listing tables:
```
describe tables;
```



