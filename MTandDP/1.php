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
