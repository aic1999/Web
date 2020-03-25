<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>FaceWrap</title>
  <link rel="stylesheet" href="style.css">
  <!-- 引入Js文件 -->
<script src="js/lb.js"></script>
<script src="js/GetPhoto.js"></script>
<style type="text/css">
/* 重置css */
* {
    margin:0;
    padding:0;
/*     background-color: orange; */
  }
  a{
    text-decoration: none;
  }
/*   
      让图片只在container中，所以需要限定其宽度和高度
   box-shadow是图片边缘阴影
      使用overflow:hidden将其余的图片隐藏起来
     希望wrap相对于container左右移动，所以设置为relative  
 */  
   .container {
    position: relative;
    width: 700px;
    height: 900px;
/*     margin:100px auto 0 auto;	 */ 
	margin-top:50px;
    box-shadow: 0 0 5px rgb(180, 182, 180);
    overflow: hidden;
  }
  /*
       设置wrap是绝对定位的(就可以通过控制Left和Right来控制图片的移动了)
   z-index:1;为了对后面将要放置的buttons作为参考
      因为共有七张图片，所以width为7*700=4900px（每张图片我们设置为700X900
    */
  .container .wrap {
    position: absolute;
    width: 4900px;
    height: 900px;
    z-index: 1;
  }
  /* 把图片设置位左浮动，并限定其大小  */
  .container .wrap img {
    float: left;
    width: 700px;
    height: 900px;
  }
  /* 显示次序的buttons（小圆点） 
            设置z-index:2;以保证buttons是在图片的上面的
  */
  .container .buttons {
    position: absolute;
    right: 5px;
    bottom:30px;
    width: 120px;
    height: 10px;
    z-index: 2;
  }
  /*将buttons下面的span做一个简单的修饰，并且给和图片对应的span设置一个on类，  */
  .container .buttons span {
    margin-left: 5px;
    display: inline-block;
    width: 12px;
    height: 12px;
    border-radius: 50%;
    background-color: rgb(211, 212, 211);
    text-align: center;
    color:white;
    cursor: pointer;
  }
  .container .buttons span.on{
    background-color: rgb(151, 150, 150);
  }
  /*左右切换的箭头,做简单的修饰
        因为这里使用实体来表示左右箭头，所以设置font-size才能改变其大小， 
   */
  .container .arrow {
    position: absolute;
    top: 40%;
    color: rgb(179, 182, 179);
    padding:0px 15px;
    border-radius: 50%;
    font-size: 50px;
    z-index: 2;
    display: none;
  }
  .container .arrow_left {
    left: 10px;
  }
  .container .arrow_right {
    right: 10px;
  }
  .container:hover .arrow {
    display: block;
  }
  .container .arrow:hover {
    background-color: rgba(0,0,0,0.2);
  }
  /* 图像的宽高设置  */
  .img{
     width: 600px;
     height: 600px;
     margin-top:100px;
     border: 1px solid lightgray;
  }
  /* 如果图片比框大，则限制成原格式大小来  */        
  .img>img{
            width: 100%;
            height: 100%;
        } 
   /*轮播片父布局的边框样式  */
   .div-b{ float:left;width:49%;border:1px solid #000} 
   /* 预览图片的样式设置 */
   .right {
      margin-left: 1010px;
      height: 900px;
    }
</style>
</head>
<body>
	<%
	//初始化轮播图，用已有的图片实现轮播
	//System.out.println(request.getAttribute("pic2")+"--------!!!!!!");
	if(request.getAttribute("pic1")==null)
		request.setAttribute("pic1","images/libai.jpg");
	if(request.getAttribute("pic2")==null)
		request.setAttribute("pic2","images/zhenji.jpg");
	if(request.getAttribute("pic3")==null)
		request.setAttribute("pic3","images/junzhuang.jpg");
	if(request.getAttribute("pic4")==null)
		request.setAttribute("pic4","images/linger.jpg");
	if(request.getAttribute("pic5")==null)
		request.setAttribute("pic5","images/wangzhaojun.jpg");
	
	%>
	 <div class="div-b">
	  <center>
	  <div class="container" >
	    <div class="wrap" style="left: -700px;">
	      <img src=${pic5} alt="5"><!-- 最后一页  -->
	      <img src=${pic1} alt="1">	<!-- 第一页 -->
	      <img src=${pic2} alt="2">		<!-- 2 -->
	      <img src=${pic3} alt="3">		<!-- 3 -->
	      <img src=${pic4} alt="4">		<!-- 4 -->
	      <img src=${pic5} alt="5">		<!-- 最后一页（用于轮播实现显示最后一页的图片） -->
	      <img src=${pic1} alt="1">	<!-- 第一页的图（用于轮播实现第一页的图片） -->
	    </div>
	    <div class="buttons">	<!-- 小圆点 -->
	      <span class="on"></span>
	      <span></span>
	      <span></span>
	      <span></span>
	      <span></span>
	    </div>
	    <!-- 左右点击 -->
	    <a href="javascript:void (0);" rel="external nofollow" class="arrow arrow_left"><</a>
	    <a href="javascript:void (0);" rel="external nofollow" class="arrow arrow_right">></a>
	  </div>
	  </center>
	 </div>  
	<!-- 预览图的提交、显示 -->
	<div class="right">
	<center><br><br><br>
 	<form action="run" method="post">
	 	<input type="file" id="file" name="path" margin-top="100px">
		<p class="img" >
		    <img src="" name="ipath"  alt="" id="img">
		</p><br><br><br>
		<input type="submit" value="submit">
 	</form>
	</center>
	</div> 
	
    </body>
</html>
