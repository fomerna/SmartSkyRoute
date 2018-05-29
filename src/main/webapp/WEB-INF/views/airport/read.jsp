<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head></head>
<body>

<section class="content">
    <div class="row">
        <!-- left column -->
        <div class="col-md-12">
            <!-- general form elements -->
            <div class="box box-primary">
                <div class="box-header">
                    <h3 class="box-title">READ AIRPORT</h3>
                </div>


                <div class="box-body">
                    <table style="border: solid"  >
                        <tr>
                            <td>${airport}</td>
                            <td>${airport.airportCode}</td>
                            <td>${airport.airportName}</td>
                            <td>${airport.city}</td>
                            <td>${airport.country}</td>
                            <td>${airport.lat}</td>
                            <td>${airport.lon}</td>
                        </tr>
                    </table>

                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
