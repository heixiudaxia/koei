# hz

## 问题小记
### docker在企业中使用避免合规问题
问题5：如何在不安装Docker Desktop的情况下，安装Docker Engine等免费软件使用？
回复5：
●Linux
1. Linux平台下可参照该文档指引安装docker enginel以及docker compose等：
https://docs.docker.com/engine/install/;
2. Linux平台下也可直接运行docker提供的安装脚本：curl-fsSL https:/get.docker..com|bash-s
docker
●Mac
1. Mac系统中，无法直接安装docker engine等，核心组件，需要自行安装linux虚拟机，
2. Mac系统中的可选替代方式为lima,安装步骤为：
■(1)使用brew安装lima:brew install lima;
■(2)使用lima安装docker::lima docker;详见Iima文档：https:/github.com/Iima-vm/lima。
3. Mac系统中，也可选择其他开源虚拟机如aemu等安装inux系统后使用dockeri相关组件。
●Win
1. Docker'官方提供了Windows.系统下的二进制安装包，
■可从以下链接下载：https:/download.docker.com/win/static/stable/x86_64/
■或直接访问dockerT官方文档下载最新版：https:/docs.docker..com/engine/install/binaries/.
2. 按照前述方法下载的docker不包含docker buildx:和compose等组件，如需使用这些组件，请安装
WSL(powershell中运行wsl-installi命令并从microsoft store中下载对应的linux发行版)或使用其
他虚拟机运行linux系统后使用docker相关组件。
