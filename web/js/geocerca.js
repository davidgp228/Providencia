
 var infoWindow;

function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: -34.397, lng: 150.644},
          zoom: 8
        });
        
         // Define an info window on the map.
        infoWindow = new google.maps.InfoWindow();

        var all_overlays = [];
        var selectedShape;
        var drawingManager = new google.maps.drawing.DrawingManager({
          drawingMode: google.maps.drawing.OverlayType.MARKER,
          drawingControl: true,
         
          drawingControlOptions: {
            position: google.maps.ControlPosition.TOP_CENTER,
            drawingModes: ['rectangle']
          },
          markerOptions: {icon: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png'},
          circleOptions: {
            fillColor: '#ffff00',
            fillOpacity: 1,
            strokeWeight: 5,
            clickable: false,
            editable: true,
            zIndex: 1
          },
          rectangleOptions: {
            draggable: true,
            editable: true,
            strokeColor: '#FF0000',
            clickable: true,
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: '#FF0000',
            fillOpacity: 0.5
        },
            
          
        });
   
        function clearSelection() {
            if (selectedShape) {
              selectedShape.setEditable(false);
              selectedShape = null;
            }
        }
        
        function setSelection(shape) {
            clearSelection();
            selectedShape = shape;
            shape.setEditable(true);
           // google.maps.event.addListener(selectedShape.getPath(), "dragend", getPolygonCoords(shape));
           // google.maps.event.addListener(selectedShape.getPath(), 'insert_at', getPolygonCoords(shape));
           // google.maps.event.addListener(selectedShape.getPath(), 'set_at', getPolygonCoords(shape));
           
          }

        
        function deleteSelectedShape() {
            if (selectedShape) {
              selectedShape.setMap(null);
            }
        }

        function deleteAllShape() {
          for (var i = 0; i < all_overlays.length; i++) {
            all_overlays[i].overlay.setMap(null);
          }
          all_overlays = [];
        }
       
        function CenterControl(controlDiv, map) {
            // Set CSS for the control border.
            var controlUI = document.createElement("div");
            controlUI.style.backgroundColor = "#fff";
            controlUI.style.border = "2px solid #fff";
            controlUI.style.borderRadius = "3px";
            controlUI.style.boxShadow = "0 2px 6px rgba(0,0,0,.3)";
            controlUI.style.cursor = "pointer";
            controlUI.style.marginBottom = "22px";
            controlUI.style.textAlign = "center";
            controlUI.title = "Select to delete the shape";
            controlDiv.appendChild(controlUI);

            // Set CSS for the control interior.
            var controlText = document.createElement("div");
            controlText.style.color = "rgb(25,25,25)";
            controlText.style.fontFamily = "Roboto,Arial,sans-serif";
            controlText.style.fontSize = "16px";
            controlText.style.lineHeight = "38px";
            controlText.style.paddingLeft = "5px";
            controlText.style.paddingRight = "5px";
            controlText.innerHTML = "Eliminar area";
            controlUI.appendChild(controlText);

            // Setup the click event listeners: simply set the map to Chicago.
            controlUI.addEventListener("click", function() {
              deleteSelectedShape();
            });
        }
       
        drawingManager.setMap(map);
        
        function getPolygonCoords(newShape) {
             alert("alert" );
            var len = newShape.getPath().getLength();
            var htmlStr = "";
            for (var i = 0; i < len; i++) {
                htmlStr += newShape.getPath().getAt(i).toUrlValue(5) + "<br>";
            }
           
        }
        
        
        google.maps.event.addListener(drawingManager, "overlaycomplete", function(
        event ) {
        
            all_overlays.push(event);
            if (event.type !== google.maps.drawing.OverlayType.MARKER) {
              drawingManager.setDrawingMode(null);
              //Write code to select the newly selected object.

              var newShape = event.overlay;
              newShape.type = event.type;
              google.maps.event.addListener(newShape, "click", function() {
                  alert("Pulsado B");
           
                  
              setSelection(newShape);
              });

              google.maps.event.addListener(newShape, "dragend", function() {
                   
              });
              google.maps.event.addListener(newShape, "bounds_changed", function() {
                  
                var ne = newShape.getBounds().getNorthEast();
                var sw = newShape.getBounds().getSouthWest();
                
                var contentString = '<b>Area movida.</b><br>' +
                'Norte-esquina este: ' + ne.lat() + ', ' + ne.lng() + '<br>' +
                'Sur-esquina oeste: ' + sw.lat() + ', ' + sw.lng();

                // Set the info window's content and position.
                infoWindow.setContent(contentString);
                infoWindow.setPosition(ne);

                infoWindow.open(map);
                        
              });
              
              setSelection(newShape);
            }
        });
        
        
        var centerControlDiv = document.createElement("div");
        var centerControl = new CenterControl(centerControlDiv, map);
         
        centerControlDiv.index = 1;
        map.controls[google.maps.ControlPosition.BOTTOM_CENTER].push(
          centerControlDiv
        );

        
}