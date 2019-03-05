 // This example adds a user-editable rectangle to the map.
      // When the user changes the bounds of the rectangle,
      // an info window pops up displaying the new bounds.

      var rectangle;
      var map;
      var infoWindow;

      function initMap() {
           if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
        
         map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: position.coords.latitude,
                  lng: position.coords.longitude},
          zoom: 15
        });

        var bounds = {
          north: position.coords.latitude,
          south: position.coords.latitude+0.01,
          east: position.coords.longitude,
          west: position.coords.longitude-0.01
        };

        // Define the rectangle and set its editable property to true.
        rectangle = new google.maps.Rectangle({
          bounds: bounds,
          fillColor: '#0099ff',
          fillOpacity: 0.1,
          strokeColor: '#0033cc',
          editable: true,
          draggable: true
        });

        rectangle.setMap(map);

        // Add an event listener on the rectangle.
        rectangle.addListener('bounds_changed', showNewRect);

        // Define an info window on the map.
        infoWindow = new google.maps.InfoWindow();
        
        });
        }
          
       
      }
      // Show the new coordinates for the rectangle in an info window.

      /** @this {google.maps.Rectangle} */
      function showNewRect(event) {
        var ne = rectangle.getBounds().getNorthEast();
        var sw = rectangle.getBounds().getSouthWest();

        var contentString = '<b>Area movida.</b><br>' +
                'Norte-esquina este: ' + ne.lat() + ', ' + ne.lng() + '<br>' +
                'Sur-esquina oeste: ' + sw.lat() + ', ' + sw.lng();

        // Set the info window's content and position.
        infoWindow.setContent(contentString);
        infoWindow.setPosition(ne);

        infoWindow.open(map);
      }
