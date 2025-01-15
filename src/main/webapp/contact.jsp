
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Contact Us</title>
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
		<h1>Contact Us</h1>
		<form action="ContactServlet" method="post">
			<div class="form-group">
				<input type="text" name="name" placeholder="Enter your Name"
					required>
			</div>
			<div class="form-group">
				<input type="email" name="email" placeholder="Enter your Email ID"
					required>
			</div>
			<div class="form-group">
				<textarea name="message" placeholder="Enter your Message" required></textarea>
			</div>
			<button class="btn submit-btn" type="submit">Submit</button>
		</form>
	</main>
</body>

</html>
