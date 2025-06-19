const base = {
    get() {
        return {
            url : "http://localhost:8080/legalCasesManage/",
            name: "legalCasesManage",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        return {
            projectName: "法律案件管理系统"
        } 
    }
}
export default base
