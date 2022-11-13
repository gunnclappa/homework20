# How to run tests

Run tests with mobile emulator:
```
gradle clean test -Denv=local
```

Run tests with Browserstack:
```
gradle clean test -Denv=browserstack
```

Run tests with real device:
```
gradle clean test -Denv=real
```
