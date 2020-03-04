$(".answer-write button[type=submit]").click(addAnswer);
$(".update-answer-form button[type=submit]").click(updateAnswer);
$(".qna-comment-slipp-articles").on("click", "a.link-delete-article",
    deleteAnswer);

function addAnswer(e) {
  e.preventDefault();
  var queryString = $(".answer-write").serialize();

  var url = $(".answer-write").attr("action");

  $.ajax({
    type: 'post',
    url: url,
    data: queryString,
    dataType: 'json',
    error: function (xhr) {
      console.log("error")
      console.log(xhr)
    },
    success: function (data) {
      console.log(data)
      if (data.valid) {
        var answerTemplate = $("#answerTemplate").html();
        var answer = data.answer;
        var template = answerTemplate.format(
            answer.writer,
            answer.createdTime,
            answer.contents,
            answer.question.id,
            answer.id);
        $(".qna-comment-slipp-articles").prepend(template);

        $("textarea[name=contents]").val("");
        // console.log("success")
      } else {
        alert(data.errorMessage);
      }

    }
  });
}

function updateAnswer(e) {
  e.preventDefault();
  var url = $(this).attr("action");
  console.log(url);
}

function deleteAnswer(e) {
  e.preventDefault();
  var deleteBtn = $(this)
  // console.log(deleteBtn);
  var url = deleteBtn.attr("href");
  // console.log(url);

  $.ajax({
    type: 'DELETE',
    url: url,
    dataType: 'json',
    error: function (xhr, status) {
      console.log(xhr);
    },
    success: function (data, status) {
      console.log(data);
      if (data.valid) {
        deleteBtn.closest("article").remove();
      } else {
        alert(data.errorMessage);
      }
    }
  })
}

String.prototype.format = function () {
  var args = arguments;
  return this.replace(/{(\d+)}/g, function (match, number) {
    return typeof args[number] != 'undefined'
        ? args[number]
        : match
        ;
  });
};






