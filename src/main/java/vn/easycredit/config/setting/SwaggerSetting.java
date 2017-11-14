package vn.easycredit.config.setting;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableList;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import vn.easycredit.constant.Constant;
import vn.easycredit.response.ErrorResponse;

/**
 * @author HienNT
 *
 */

@Component
@ConfigurationProperties(prefix="swagger")
public class SwaggerSetting {

    ApiInfo info;
    
    public ApiInfo getInfo() {
		return info;
	}

	public void setInfo(ApiInfo info) {
		this.info = info;
	}

    public List<ResponseMessage> getGlobalResponseMessages() {
        ModelRef errorModelRef = new ModelRef(ErrorResponse.class.getSimpleName());
        return ImmutableList.of(
                new ResponseMessageBuilder()
                        .code(500)
                        .message(Constant.INTERNALERROR_MESSAGE)
                        .responseModel(errorModelRef)
                        .build(),
                new ResponseMessageBuilder()
                        .code(400)
                        .message(Constant.BADREQUEST_MESSAGE)
                        .responseModel(errorModelRef)
                        .build());
    }

    public static class ApiInfo {
        private String version;
        private String title;
        private String description;
        private String termsOfServiceUrl;
        private String license;
        private String licenseUrl;
        private Contact contact;

        public springfox.documentation.service.ApiInfo asSwaggerApiInfo() {
            return new ApiInfoBuilder()
                    .version(version)
                    .title(title)
                    .description(description)
                    .termsOfServiceUrl(termsOfServiceUrl)
                    .license(license)
                    .licenseUrl(licenseUrl)
                    .contact(contact.asSwaggerContact())
                    .build();
        }

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getTermsOfServiceUrl() {
			return termsOfServiceUrl;
		}

		public void setTermsOfServiceUrl(String termsOfServiceUrl) {
			this.termsOfServiceUrl = termsOfServiceUrl;
		}

		public String getLicense() {
			return license;
		}

		public void setLicense(String license) {
			this.license = license;
		}

		public String getLicenseUrl() {
			return licenseUrl;
		}

		public void setLicenseUrl(String licenseUrl) {
			this.licenseUrl = licenseUrl;
		}

		public Contact getContact() {
			return contact;
		}

		public void setContact(Contact contact) {
			this.contact = contact;
		}
    }

    public static class Contact {
        private String name;
        private String url;
        private String email;

        public springfox.documentation.service.Contact asSwaggerContact() {
            return new springfox.documentation.service.Contact(name, url, email);
        }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
    }
}
