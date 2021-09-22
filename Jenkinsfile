pipeline {
    agent any
    stages {
        stage('Checkout git') {
            steps {
                git(url: 'https://github.com/rofitasm/try-testing-pipeline.git', branch: 'master')
            }
        }
        stage('Running test') {
            steps {
                bat 'mvn verify -Dcucumber.options="--tags @Pokemon"'
            }
        }
        stage('Cucumber Reports') {
            steps {
                cucumber buildStatus: 'UNSTABLE',
                        reportTitle: 'Search Backend Cucumber Report',
                        jsonReportDirectory: 'target',
                        fileIncludePattern: '**/destination/cucumber.json',
                        sortingMethod: 'ALPHABETICAL',
                        trendsLimit: 100
            }
        }
    }
}