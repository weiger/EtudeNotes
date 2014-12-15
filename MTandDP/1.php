<?php
$headers = array("Content-Type:multipart/form-data"); // cURL headers for file uploading
$postfields = array("file" => "@".realpath($url), "user" => "Xiaomeng Yi", "key" => "Budweiser","file_name"=>$file_name);
$ch = curl_init();
$options = array(
    CURLOPT_URL => "http://tuolei.org///endpoint.php",
    CURLOPT_HEADER => true,
    CURLOPT_POST => 1,
    CURLOPT_HTTPHEADER => $headers,
    CURLOPT_POSTFIELDS => $postfields,
    CURLOPT_INFILESIZE => $size,
    CURLOPT_RETURNTRANSFER => 1
); // cURL options
curl_setopt_array($ch, $options);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
$response = curl_exec($ch);
curl_close($ch);
/*************************************************************/
$url = "http://localhost/post_output.php";
$post_data = array (
    "foo" => "bar",
    "query" => "Nettuts",
    "action" => "Submit"
);
$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
// 我们在POST数据哦！
curl_setopt($ch, CURLOPT_POST, 1);
// 把post的变量加上
curl_setopt($ch, CURLOPT_POSTFIELDS, $post_data);
$output = curl_exec($ch);
curl_close($ch);
echo $output;
/**********************************/
<?php 
$filename=$_GET['fileName'];
$fileData=file_get_contents('php://input');

if (!file_exists('../uploads/'))
{
	mkdir ("../uploads");
}


move_uploaded_file($_FILES["fileName"],"upload/" . $_FILES["fileName"]);
$fhandle=fopen("./uploads/".$filename, 'wb');

fwrite($fhandle, $fileData);
fclose($fhandle);
echo("File Uploaded Successfully!");
?>

/*********************************/
<script>
function goBack() {
	window.history.back()
}
</script>
<body>
	<?php   
	//var_dump($_POST);
	$link = mysqli_connect("mysql","iloveoottat","selina1031","cmpe207data");
	if (!$link)
	{
		die('Could not connect: ' . mysqli_error());
	} 	

	mysqli_select_db($link,"cmpe207data") or die("Could not select database");
 
	$query = "SELECT * FROM info";   
	$result = mysqli_query($link,$query) or die("Query failed");  	

	$QueryOption = isset($_POST['QueryOption']) ? $_POST['QueryOption']:null;

	switch ($QueryOption) {
    case "0":
		    echo "<table border='2'>\n"; 
			echo "<tr><td>ID</td><td>First Name</td> <td>Last Name</td> <td>Gender</td> <td>Courses</td></tr>"; 
			while ($line = mysqli_fetch_array($result, MYSQL_ASSOC)) {        
				echo "\t<tr>\n";        
					foreach ($line as $col_value) {            print "\t\t<td>$col_value</td>\n";        }        
				echo"\t</tr>\n";    }    
			echo "</table>\n";   
        break;
    case '1':
			echo "<table border='2'>\n"; 
        	echo "<tr><td>ID</td></td></tr>"; 
			while ($line = mysqli_fetch_array($result, MYSQL_ASSOC)) {        
				echo "\t<tr>\n";
					print "\t\t<td>".$line['student']."</td>\n";  
				echo"\t</tr>\n"; 
			}    
			echo "</table>\n"; 
        break;
    case '2':
			echo "<table border='2'>\n"; 
        	echo "<tr><td>FirstName</td></td></tr>"; 
			while ($line = mysqli_fetch_array($result, MYSQL_ASSOC)) {        
				echo "\t<tr>\n";
					print "\t\t<td>".$line['firstname']."</td>\n";  
				echo"\t</tr>\n"; 
			}    
			echo "</table>\n"; 
        break;
    case '3':
    		echo "<table border='2'>\n"; 
        	echo "<tr><td>LastName</td></td></tr>"; 
			while ($line = mysqli_fetch_array($result, MYSQL_ASSOC)) {        
				echo "\t<tr>\n";
					print "\t\t<td>".$line['lastname']."</td>\n";  
				echo"\t</tr>\n"; 
			}    
			echo "</table>\n"; 
        break;
    case '4':
    		echo "<table border='2'>\n"; 
        	echo "<tr><td>Gender</td></td></tr>"; 
			while ($line = mysqli_fetch_array($result, MYSQL_ASSOC)) {        
				echo "\t<tr>\n";
					print "\t\t<td>".$line['sex']."</td>\n";  
				echo"\t</tr>\n"; 
			}    
			echo "</table>\n"; 
        break;  
    case '5':
    		echo "<table border='2'>\n"; 
        	echo "<tr><td>Courses</td></td></tr>"; 
			while ($line = mysqli_fetch_array($result, MYSQL_ASSOC)) {        
				echo "\t<tr>\n";
					print "\t\t<td>".$line['course']."</td>\n";  
				echo"\t</tr>\n"; 
			}    
			echo "</table>\n"; 
        break;    
	}

	
	mysqli_free_result($result);    
 

	mysqli_close($link);
	?>

	<button onclick="goBack()">Go Back</button>
</body>
