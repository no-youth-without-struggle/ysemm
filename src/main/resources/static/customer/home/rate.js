function getRate(type,principal,months,rate) {
    let data=[4];
    if (type=="等额本息"){
        let monthRate = rate / (100 * 12);//月利率
        let preLoan = (principal * monthRate * Math.pow((1 + monthRate), months)) / (Math.pow((1 + monthRate), months) - 1);//每月还款金额
        let totalMoney = preLoan * months;//还款总额
        let interest = totalMoney - principal;//还款总利息
        data[0]=monthRate;
        data[1]=preLoan;
        data[2]=totalMoney;
        data[3]=interest;
    }
    return data;
}

function getRA(type,moneys,periodss,yearInterests) {
    let money = moneys; // 贷款本金

    let periods = periodss; // 期数

    let yearInterest = yearInterests; // 年率

    let month = null; // 月率


    let monthInterest = null; // 每月偿还本息

    let resultArr = []; // 每月偿还利息

    let resultMoneyArr = []; // 每月偿还本金

    let monthMoney = []; // 每月剩余本金

    let allMoney=0;//总金额

    let allRate=0;//总利息


// 月率

    month = parseInt(yearInterest, 10) / 100 / 12;


// 公式 贷款本金×月利率×(1＋月利率)^还款月数〕÷〔(1＋月利率)^还款月数 - 1〕

    let repayMonthPow = Math.pow((1 + month), periods);

    monthInterest = ((money * month * repayMonthPow) / (repayMonthPow - 1)).toFixed(2);


// 每月偿还本息

    let _money = money;

    for (let i = 0, len = periods; i < len; i++) {

        _money -= (monthInterest - (_money * month));

        monthMoney.push(parseFloat(_money.toFixed(2)));

    }


// 每月偿还利息

    resultArr = monthMoney.map((value) => {
        return (value * month).toFixed(2);
    });
    //总利息
    for (var i=0;i<resultArr.length;i++){
        allRate=allRate+resultArr[i];
    }
    return allRate;


// 将第一个月利息插入

    resultArr.unshift((money * month));

    resultArr.pop();


// 每月偿还本金

    resultMoneyArr = resultArr.map((value) => {

        return monthInterest - value;

    });


    console.log(monthInterest);

    console.log(resultMoneyArr);

    console.log(resultArr);

    console.log(monthMoney);
}