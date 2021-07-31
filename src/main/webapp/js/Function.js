function setReadOnly(flags) {
    if (flags) {
        $("input").prop("readonly", true);
        $("input[type='checkbox']").prop("disabled", true);
        $("input[type='radio']").prop("disabled", true);
        $("input[type='button']").prop("disabled", false);
        $("textarea").prop("readonly", true);
        $("button").remove();
        $("select").prop("disabled", true);
    } else {
        //don't need set readonly
    }
}