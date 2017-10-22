#!/usr/bin/env sh
cd ./..
pwd
./gradlew clean --refresh-dependencies -x test -x check assemble -P projectEnv=prod --stacktrace

mv -f ./build/libs/huaqi.jar ./docker