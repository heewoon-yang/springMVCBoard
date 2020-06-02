/**
 * CKEditor 5
 */

ClassicEditor
	.create(document.querySelector('#content'))
	.then(editor => {
		console.log(editor);
	})
	.catch(error => {
		console.error(error);
	})