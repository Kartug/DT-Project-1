<!DOCTYPE html>

<html lang="en">

<head>
<%@include file="/WEB-INF/views/Header.jsp"%>
</head>
<body>


	<div id="all">

	
	

	
	<div id="heading-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-md-7">
						<h1>Shipping details</h1>
					</div>
					<div class="col-md-5">
						<ul class="breadcrumb">
							<li><a href="<c:url value="/"/>">Home</a></li>
							<li><a href="<c:url value="/user/cart"/>">My Cart</a></li>
							<li>Shipping details</li>
							
						</ul>

					</div>
				</div>
			</div>
		</div>
	<section>
	
	
	
	
	  <div id="content">
	<div class="container">
				
		<br><br>
		
            <div class="row">
				
                <div class="col-lg-8 col-lg-offset-2">
                <div class="pull-center">
                
                   <h3 align="center" > Enter your Shipping details</h3>
                   </div>
                    <form id="contact-form" method="post" action="thankYouPage"commandName="Shippingdetail" >                        

                        <div class="controls">

                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="form_name">Firstname *</label>
                                        <input id="form_name" type="text" name="name" class="form-control" placeholder="Please enter your firstname *" required="required" data-error="Firstname is required.">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="form_lastname">Lastname </label>
                                        <input id="form_lastname" type="text" name="surname" class="form-control" placeholder="Please enter your lastname *" >
                                      
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="form_email">Email *</label>
                                        <input id="form_email" type="email" name="email" class="form-control" placeholder="Please enter your email *" required="required" data-error="Valid email is required.">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="form_phone">Phone *</label>
                                        <input id="form_phone" type="text" name="phone" class="form-control" placeholder="Please enter your phone  *" required="required" data-error="phone is required.">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="form_address1">Address Line1 *</label>
                                        <input id="form_address1" type="text" name="address1" class="form-control" placeholder="Please enter your address line 1 *" required="required" data-error="address1 is required.">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="form_address2">Address Line 2 *</label>
                                        <input id="form_address2" type="text" name="address2" class="form-control" placeholder="Please enter your address2 *" required="required" data-error="address2 is required.">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                            </div>
                           
                            
                            
                           <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="form_city">City *</label>
                                        <input id="form_city" type="text" name="city" class="form-control" placeholder="Please enter your city *" required="required" data-error="city is required.">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="form_state">State *</label>
                                        <input id="form_state" type="text" name="state" class="form-control" placeholder="Please enter your state *" required="required" data-error="state is required.">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="form_zipcode">Zipcode *</label>
                                        <input id="form_zipcode" type="text" name="zipcode" class="form-control" placeholder="Please enter your zipcode *" required="required" data-error="zipcode is required.">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <!-- <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="form_lastname">Lastname *</label>
                                        <input id="form_lastname" type="text" name="surname" class="form-control" placeholder="Please enter your lastname *" required="required" data-error="Lastname is required.">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>  <br><br><br>-->
                            </div>
                              <br><br>
                             <div class="col-sm-12 text-center">
                               <button type="submit" class="btn btn-template-main">Submit</button>
                             </div>
                                    
                             <br><br><br>
                             
                            <div class="row">
                                <div class="col-md-12">
                                    <p class="text-muted"><strong>*</strong> These fields are required. </p>
                                </div>
                            </div>
                        </div>

                    </form>

                </div><!-- /.8 -->

            </div> <!-- /.row-->
            
</div> <!-- /.container-->
	</div>
	
	
	</section>




		<%-- <%@include file="/WEB-INF/views/footer.jsp"%> --%>

	</div>
	<!-- /#all -->
	<!-- #### JAVASCRIPT FILES ### -->
	<%@include file="/WEB-INF/views/scriptfiles.jsp"%>
</body>
</html>