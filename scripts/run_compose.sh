#!/bin/bash

docker-compose -f old-system/docker-compose.yaml up -d

if [ $? -eq 0 ]; then
    echo "Успешно - old-system"
else
    echo "Ошибка при поднятии БД - old-system"
    exit 1
fi

docker-compose -f new-system/docker-compose.yaml up -d

if [ $? -eq 0 ]; then
    echo "Успешно - new-system"
else
    echo "Ошибка при поднятии БД - new-system"
    exit 1
fi
