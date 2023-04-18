const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot7cox6/",
            name: "springboot7cox6",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot7cox6/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "高校志愿者服务管理系统的设计与开发"
        } 
    }
}
export default base
