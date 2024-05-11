const token = "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJjYW1wdXNjbCIsInN1YiI6ImpvaGFuIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTcxNTQxNTUwMCwiZXhwIjoxNzE2Mjc5NTAwfQ.i98hQmbmgaCHBBgytbdqzh37Fr8EqyuQ3F49ggHzuNgS-RsMUcbV3ab5VqTA2yuiXK-RgLLf3zWaTNKPvtxRfw";

const url = "http://localhost:8080/empresa"


function cargarDatos() {
    console.log("hola")
    $.ajax({
        url: url+"/",
        method: 'GET',
        headers:{
            'Authorization': "Bearer " + token
        },
        success: (data) =>{
            $('.empresa-tbody').empty();
            data.forEach(element => {
                $('.empresa-tbody').append(`
                <tr data-id="${element.idempresa}" >
                    <th scope="row">${element.idempresa}</th>
                    <td>${element.identificacion}</td>
                    <td>${element.razonsocial}</td>
                    <td>
                        <button type="button" class="btn btn-danger btn-delet">Eliminar</button>
                        <button type="button" class="btn btn-warning btn-edit">Editar</button>
                    </td>
                </tr>
                
                `);
            });
        }
    })
}


$('.form-empre').submit((event) => {
    event.preventDefault();
    let idente = $('#in-ident-empre').val();
    let razonsocial = $('#in-razon-empre').val();

    let metodo = 'POST';
    $.ajax({
        url: url+"/" ,
        method: metodo,
        contentType: 'application/json',
        headers: {
            'Authorization': 'Bearer ' + token
        },
        data: JSON.stringify({identificacion: idente , razonsocial: razonsocial}),
        success: () => {
            cargarDatos();
        }
    });
});

$('.empresa-tbody').on('click', '.btn-delet', function() {
    let fila = $(this).closest('tr');
    let id = fila.attr('data-id');
    if (confirm('¿Estás seguro de eliminar este registro?')) {
        $.ajax({
            url: `${url}/${id}`,
            method: 'DELETE',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function() {
                fila.remove();
            },
            error: function(xhr, status, error) {
                console.error('Error al eliminar el registro:', status, error);
            }
        });
    }
});


$(document).ready(() =>{
    cargarDatos();
});



