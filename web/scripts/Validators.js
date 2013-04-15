function checkEmail( strValue ){
    //alert("checkEmail");
    var objRegExp = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$/;
    
    //check for valid email format
    return objRegExp.test(strValue);
}

function  checkNumeric( strValue ) {
    //alert("checkNumeric");
    var objRegExp  =  /(^-?\d\d*\.\d*$)|(^-?\d\d*$)|(^-?\.\d\d*$)/;

    //check for numeric characters
    return objRegExp.test(strValue);
}

function checkInteger( strValue ) {
    //alert("checkInteger");
    var objRegExp  = /(^-?\d\d*$)/;

    //check for integer characters
    return objRegExp.test(strValue);
}

function checkNotEmpty( strValue ) {
    //alert("checkNotEmpty");
    var strTemp = strValue;

    strTemp = trimAll(strTemp);
    if(strTemp.length > 0){
        return true;
    }
    return false;
}

function trimAll( strValue ) {
    var objRegExp = /^(\s*)$/;

    //check for all spaces
    if(objRegExp.test(strValue)) {
        strValue = strValue.replace(objRegExp, '');
        if( strValue.length == 0)
            return strValue;
    }

    //check for leading & trailing spaces
    objRegExp = /^(\s*)([\W\w]*)(\b\s*$)/;
    if(objRegExp.test(strValue)) {
        //remove leading and trailing whitespace characters
        strValue = strValue.replace(objRegExp, '$2');
    }
    return strValue;
}
