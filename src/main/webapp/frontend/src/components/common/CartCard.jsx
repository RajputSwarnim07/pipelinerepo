import React from "react";
import {
	MDBBtn,
	MDBCard,
	MDBCardBody,
	MDBCardImage,
	MDBCol,
	MDBIcon,
	MDBRow,
	MDBTypography,
} from "mdb-react-ui-kit";

export default function CartCard(prod) {
	return (
		<MDBCard
			style={{ backgroundColor: "#EDF1D6" }}
			className="rounded-3 mb-4"
		>
			<MDBCardBody className="p-4">
				<MDBRow className="justify-content-between align-items-center">
					<MDBCol md="2" lg="2" xl="2">
						<MDBCardImage
							className="rounded-3"
							fluid
							src="https://www.wellplannedjourney.com/wp-content/uploads/Best-Outdoor-Products-Amazon.jpg"
							alt="Cotton T-shirt"
						/>
					</MDBCol>
					<MDBCol md="3" lg="3" xl="3">
						<p className="lead fw-normal mb-2">
							{/* Product Name */}
							{prod.name}
						</p>
						<p>
							<span className="text-muted">Size: </span>
							{prod.size}
							<br />
							<span className="text-muted">Color: </span>
							{prod.color}
							<br />
							<span className="text-muted">Category: </span>
							{prod.category}
						</p>
					</MDBCol>
					{prod.showAddButton && (
						<MDBCol
							md="3"
							lg="3"
							xl="2"
							className="d-flex align-items-center justify-content-around"
						>
							<MDBBtn
								outline
								color="success"
								className="px-2"
								onClick={() => prod.add(prod)}
							>
								Add Another <MDBIcon fas icon="plus" />
							</MDBBtn>
						</MDBCol>
					)}
					<MDBCol md="3" lg="2" xl="2" className="offset-lg-1">
						<MDBTypography tag="h5" className="mb-0">
							₹{prod.price}
						</MDBTypography>
					</MDBCol>
					<MDBCol md="1" lg="1" xl="1" className="text-end">
						<button
							style={{
								border: "none",
								backgroundColor: "#EDF1D6",
							}}
							className="text-danger"
							onClick={() => prod.delete(prod)}
						>
							<MDBIcon fas icon="trash text-danger" size="lg" />
						</button>
					</MDBCol>
				</MDBRow>
			</MDBCardBody>
		</MDBCard>
	);
}
