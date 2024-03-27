<script src="<%= request.getContextPath() %>/assets/js/core/jquery.min.js"></script>
	<script src="<%= request.getContextPath() %>/assets/js/core/popper.min.js"></script>
	<script src="<%= request.getContextPath() %>/assets/js/core/bootstrap.min.js"></script>
	<script src="<%= request.getContextPath() %>/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
	<!--  Google Maps Plugin    -->
	<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
	<!-- Chart JS -->
	<script src="<%= request.getContextPath() %>/assets/js/plugins/chartjs.min.js"></script>
	<!--  Notifications Plugin    -->
	<script src="<%= request.getContextPath() %>/assets/js/plugins/bootstrap-notify.js"></script>
	<!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
	<script src="<%= request.getContextPath() %>/assets/js/paper-dashboard.min.js?v=2.0.1"
		type="text/javascript"></script>
	<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
	<script src="<%= request.getContextPath() %>/assets/demo/demo.js"></script>
	<script>
		$(document).ready(function() {
			// Javascript method's body can be found in assets/assets-for-demo/js/demo.js
			demo.initChartsPages();
		});
	</script>