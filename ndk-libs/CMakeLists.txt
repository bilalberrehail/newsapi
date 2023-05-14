# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

cmake_minimum_required(VERSION 3.10.2)

find_library(log-lib log)

add_library(service-url SHARED ../.secure/url/service-url.cpp)
add_library(service-api-keys SHARED ../.secure/keys/service-api-keys.cpp)

target_link_libraries(service-url ${log-lib})
target_link_libraries(service-api-keys ${log-lib})