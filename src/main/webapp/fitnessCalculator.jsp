
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Fitness Calculator</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<header>

		<ul class="navbar">
			<li><a href="index.html">Home</a></li>
			<li><a href="fitnessCalculator.jsp">Fitness Calculator</a></li>
		</ul>
	</header>

	<main class="container">
		<h1>Fitness Calculator</h1>
		<form action="CalculateFitnessServlet" method="post">
			<div class="form-group">
				<label for="weight">Enter your Weight (kg):</label> <input
					type="number" name="weight" id="weight" required>
			</div>
			<div class="form-group">
				<label for="height">Enter your Height (cm):</label> <input
					type="number" name="height" id="height" required>
			</div>
			<button class="btn submit-btn" type="submit">Calculate</button>
		</form>
	</main>
</body>
</html>
