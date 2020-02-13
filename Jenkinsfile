node("master") {
    docker.withRegistry('https://hub.docker.com/repository/docker/rsharma12345/rsharma_docker', 'docker') {
    
        git url: "https://github.com/rsharma-github/nolimits.git", credentialsId: 'git'
    
        sh "git rev-parse HEAD > .git/commit-id"
        def commit_id = readFile('.git/commit-id').trim()
        println commit_id
    
        stage "build"
        def app = docker.build "Hackathon:${env.BUILD_ID}"
    
        stage "publish"
        app.push 'master'
        app.push "${commit_id}"
    }
}
