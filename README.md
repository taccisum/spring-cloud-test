应用启动顺序：
- eureka -> clients(client之间按依赖顺序启动)
- eureka -> config-center -> clients(依赖配置服务器的client)
