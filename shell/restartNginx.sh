#!/bin/bash
ps -ef | grep nginx | grep -v grep | grep -v consul-template
if [ $? -ne 0 ]
then
	/usr/local/openresty/nginx/sbin/nginx
	echo "nginx start"
else
	/usr/local/openresty/nginx/sbin/nginx -s reload
	echo "nginx reload"
fi