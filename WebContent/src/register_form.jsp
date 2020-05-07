<%@ page import = "edu.ucam.classes.*" %>

<div class="modal fade" id="modalRegisterForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <form class="modal-content" action = "<%=request.getContextPath()%>/Register" method = "post">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">Sign in</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      
      <div class="modal-body mx-3">
      	<div class="md-form mb-4">
          <i class="fas fa-user prefix grey-text"></i>
          <input type="text" id="defaultForm-pass" name = "<%=User.USER_USERNAME_PARAM%>" class="form-control validate required">
          <label data-error="wrong" data-success="right" for="defaultForm-pass">Username</label>
      	</div>
      
        <div class="md-form mb-5">
          <i class="fas fa-envelope prefix grey-text"></i>
          <input type="email" id="defaultForm-email" name = "<%=User.USER_EMAIL_PARAM%>" class="form-control validate required">
          <label data-error="wrong" data-success="right" for="defaultForm-email">Email</label>
       </div>

       <div class="md-form mb-4">
          <i class="fas fa-lock prefix grey-text"></i>
          <input type="password" id="defaultForm-pass" name = "<%=User.USER_PASSWORD_PARAM%>" class="form-control validate required">
          <label data-error="wrong" data-success="right" for="defaultForm-pass">Password</label>
       </div>
        
       <div class="md-form mb-4">
          <i class="fas fa-lock prefix grey-text"></i>
          <input type="password" id="defaultForm-pass" name = "<%=User.USER_REPEAT_PASSWORD_PARAM%>"class="form-control validate required">
          <label data-error="wrong" data-success="right" for="defaultForm-pass">Repeat password</label>
       </div>
       
       <div class="md-form mb-4">
          <i class="fas fa-address-card prefix grey-text"></i>
          <input type="text" id="defaultForm-pass" name = "<%=User.USER_ADDRESS_PARAM%>"class="form-control validate required">
          <label data-error="wrong" data-success="right" for="defaultForm-pass">Address</label>
       </div>

      </div>
      <div class="modal-footer d-flex justify-content-center">
        <input type = "submit" value = "Register" class="btn btn-default">
      </div>
    </form>
  </div>
</div>