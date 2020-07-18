
## echo-svc 提供回显服务

## user-svc 提供用户服务


构建镜像命令：
docker build -f Dockerfile.svcuser -t 192.168.2.2:5000/svcuser:v1 .

启动registry服务：
docker pull registry:2
docker run -d -p 5000:5000 --name registry -v /mnt/docker/data/registry:/var/lib/registry registry:2
docker tag user:v1 localhost:5000/user:v1
docker push 192.168.64.1:5000/svcuser

查询registry中的镜像
curl http://192.168.64.1:5000/v2/user/tags/list

https://www.jianshu.com/p/00ac18fce367

启动容器：
docker run --name u1 -d -p 8080:8080 user:v1

进入容器：
docker exec -it u1 /bin/bash

Docker Machine使用
https://yeasy.gitbooks.io/docker_practice/machine/usage.html

创建
docker-machine create -d xhyve \
      --xhyve-boot2docker-url ~/.docker/machine/cache/boot2docker.iso \
      --engine-opt dns=114.114.114.114 \
      --engine-registry-mirror https://registry.docker-cn.com \
      test1

查看
docker-machine ls

ssh进入
docker-machine ssh


docker swarm

创建manager节点
docker swarm init

查看节点状态
docker node ls

查询加入命令
docker swarm join-token [worker,manager]

worker加入
docker swarm join --token SWMTKN-1-5tykvcyovqt8llw8xhx35vxmf63gcw91nhd631epuvkz1x0w9m-3eg2sd3hgwkbzd39g8b6670z0 192.168.64.2:2377

离开集群
docker swarm leave

删除节点
docker node rm nodeid

提升node为manager
docker node promote nodeid

网络管理
docker network ls
docker network create -d overlay user_net

创建服务
docker service create --replicas 2 -p 8080:8080 --name svcuser --network=user_net 192.168.64.1:5000/svcuser:v1

查看服务
docker service ls

查看服务详情
docker service ps nginx

删除服务
docker service rm nginx

调整服务节点数
docker service update --replicas 3 user
docker service scale user=3

服务升级
docker service update --image 192.168.64.1:5000/webuser:v2 --update-delay 10s  webuser

compose文件方式
查看：
docker stack ls
docker stack ps user
docker stack service user

启动：
docker stack deploy -c docker-user.yaml user
删除：
docker stack rm user


配置
查看
docker config ls
创建
docker config myconfig config.json
使用
--config source=myconfig,target=/etc/nginx/conf.d/site.conf,mode=0440
docker service create --replicas 2 --config source=myconfig,target=/app/user/config.json,mode=0440 --name svcuser --network=user_net 192.168.64.1:5000/svcuser:v1
更新
docker service update --config-rm myconfig --config-add source=myconfig,target=/app/user/config.json,mode=0440 svcuser

