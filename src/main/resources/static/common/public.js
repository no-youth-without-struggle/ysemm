function getSession(){
    var userInfo;
    axios.post("/login/getSession")
        .then(function (response) {
            userInfo = response.data;
           alert(userInfo+".....");
            return userInfo;
        })
    alert(userInfo);
    return userInfo;
}