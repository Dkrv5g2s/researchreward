function setReadOnly(flags){
    if (flags == true){
        $("input").prop("readonly",true);
        $("textarea").prop("readonly",true);
        $("button").prop("disabled",true);
    }else{
        //don't need set readonly
    }
}