function modifiDisciplines() {
    var items = $("input[type=checkbox]:checked");

    if(items.length==0){
        alert('Пожалуйста выберите хотя бы одну дисциплину');
        return;
    }

    if(items.length>1){
        alert('Пожалуйста выберите только одну дисциплину');
        return;
    }

    var id = $(items).attr("id");
    $('#idModifyingDisciplineHidden').val(id);
    $('#disciplina-modyfying-form').submit();
}
function deleteDisciplines() {
    var items = $("input[type=checkbox]:checked");

    if(items.length==0){
        alert('Пожалуйста выбкрите хотя бы одну дисциплину')
        return;
    }

    var ids = "";
    for (var i = 0; i<items.length; i++){
        ids = ids+$(items[i]).attr("id")+","
    }
    $('#idRemoveDisciplineHidden').val(ids);
    $('#disciplina-remove-form').submit();

}