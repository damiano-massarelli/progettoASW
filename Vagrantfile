# 
# Vagrantfile per un singolo nodo (dev, developer) 
# per la compilazione dei progetti, 
# con Oracle Java, Gradle e Maven. 
# 

VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
    # Configurazioni comuni.

    # Ubuntu Trusty (14.04 LTS) 64 bit VirtualBox.
    config.vm.box = "ubuntu/trusty64"
    # config.vm.box_url = "http://files.vagrantup.com/ubuntu/trusty64.box"

    # folder per i progetti Asw (/home/vagrant/projects)
    config.vm.synced_folder ".", "/home/vagrant/projects", :mount_options => ["dmode=777", "fmode=777"]

    # folder per le risorse condivise per gli ambienti Asw (/home/vagrant/shared/resources e /home/vagrant/shared/scripts) 
    config.vm.synced_folder "shared/", "/home/vagrant/shared", :mount_options => ["dmode=777", "fmode=777"]

    # folder per i progetti docker Asw (/home/vagrant/docker)
    # config.vm.synced_folder "../../docker/", "/home/vagrant/docker", :mount_options => ["dmode=777", "fmode=777"]

    #
    # Configurazione del nodo "dev", che prevede: 
    # - Oracle Java SDK 8 
    # - Gradle 
    # - Apache Maven 
    #
    config.vm.define "dev" do |node|
        node.vm.hostname = "dev"    
        node.vm.network "private_network", ip: "127.0.0.1", virtualbox__intnet: true

        node.vm.provider "virtualbox" do |v| 
            # queste risorse dovrebbero bastare nella maggior parte dei casi
			v.memory = 1536 
			v.cpus = 1
			# tranne il caso in cui si vogliono lanciare piu' applicazioni Spring 
            # v.memory = 4096 
            # v.cpus = 2
        end 

        node.vm.network "forwarded_port", guest: 22, host: 2222, id: 'ssh', auto_correct: true 
        node.ssh.forward_agent = true
 
        # talvolta può essere utile pubblicare la porta 8080 di dev (su 8088)
        node.vm.network "forwarded_port", guest: 8080, host: 8080, id: 'http', auto_correct: true

        # provisioning con bash 
        node.vm.provision :shell, :inline => 'apt-get update'
        node.vm.provision :shell, path: "shared/scripts/setup-java.sh"
        node.vm.provision :shell, path: "shared/scripts/setup-gradle.sh"
        node.vm.provision :shell, path: "shared/scripts/setup-maven.sh"
        node.vm.provision :shell, path: "./projects/build.sh"
        node.vm.provision :shell, path: "./projects/run.sh"
  
        node.vm.provision :shell, 
            inline: "echo  'configurazione nodo developer completata'"

    end

end
