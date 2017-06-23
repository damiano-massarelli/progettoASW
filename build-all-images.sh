source "docker.env"

# DOCKER_REGISTRY=localhost:5000
DOCKER_REGISTRY=swarm.inf.uniroma3.it:5000

docker build --rm -t ${DOCKER_REGISTRY}/eureka-9008 ./eureka 
docker build --rm -t ${DOCKER_REGISTRY}/bandinfo-9008 ./Bandinfo 
docker build --rm -t ${DOCKER_REGISTRY}/s1-9008 ./BandinfoS1Genre
docker build --rm -t ${DOCKER_REGISTRY}/s2-9008 ./BandinfoS2Album
docker build --rm -t ${DOCKER_REGISTRY}/s3-9008 ./BandinfoS3Track
docker build --rm -t ${DOCKER_REGISTRY}/zuul-9008 ./zuul
