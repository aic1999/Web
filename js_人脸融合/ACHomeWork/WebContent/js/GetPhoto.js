
window.onload=function () {
	    
	//取得jsp的标签对象，为了取得file的路径
         var file=document.getElementById('file');	
       //取得jsp的标签对象，为了显示选中file的图片
         var img=document.getElementById('img');	
         var dataImg;	//定义图片对象
       
         file.onchange=function () {
         //判断是否支持FileReader
             if(typeof FileReader==="undefined"){
            	 	//弹窗提示信息
                     alert('您的浏览器不支持，最好使用QQ浏览器、微软Edge浏览器');
             }
             //读取文件
             var result=this.files[0];
             //获取文件类型
             var type=result.type;
             if(!type){
                 alert('请上传图片');
             }else {
            	 //判断图片类型
                 type=type.split('/')[1];
                 console.log(type);
    
                 //使用正则表达式匹配判断是否是jpeg,jpg,png,bmp,gif图片类型
                  if(type.match(/^(jpg|bmp|png|jpeg|gif)$/g)){
                     console.log(result);	//debug用
                     //声明一个fileReader
                     var reader=new FileReader();
                     //以数据流的形式读取图片
                     reader.readAsDataURL(result);
                     //图片读取完毕后执行操作
                     reader.onload=function (e) {
                         //获取图片读取结果
                     dataImg=this.result;
                         //加载图片到标签上
                        img.setAttribute('src',dataImg);
                
                     };
                 }
                 else {
                	 //弹窗提示
                      alert("请选择正确的图片格式");
                      //清空input的value值
                      this.value='';
                  }
             }
         }
    }