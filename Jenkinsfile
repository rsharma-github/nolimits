node("docker") {
    docker.withRegistry('rsharma_docker', 'rsharma12345/rsharma12345') {
    
        git url: "https://github.com/rsharma-github/nolimits.git", credentialsId: 'rsharma-github/#Welcome123'
    
        sh "git rev-parse HEAD > .git/commit-id"
        def commit_id = readFile('.git/commit-id').trim()
        println commit_id
    
        stage "build"
        def app = docker.build "Hackathon"
    
        stage "publish"
        app.push 'master'
        app.push "${commit_id}"
    }
}
