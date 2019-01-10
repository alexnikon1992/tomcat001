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